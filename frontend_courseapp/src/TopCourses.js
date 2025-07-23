// src/TopCourses.js
import React, { useEffect, useState } from 'react';
import './TopCourses.css';

function TopCourses() {
  const [courses, setCourses] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch(`${process.env.REACT_APP_BACKEND_URL}/products`)
      .then(res => {
        if (!res.ok) throw new Error(`Greška: ${res.status}`);
        return res.json();
      })
      .then(data => {
        setCourses(data.slice(0, 10)); 
        setLoading(false);
      })
      .catch(err => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <p className="loading">Učitavam top 10 zanimanja, molim pričekajte...</p>;
  if (error) return <p className="error">Došlo je do greške: {error}</p>;

  return (
    <div className="top-courses-container">
      <h1>Top 10 Zanimanja</h1>
      <ul className="courses-list">
        {courses.map(({ id, title, description }) => (
          <li key={id} className="course-item" tabIndex="0">
            <h3 className="course-title">{title}</h3>
            <p className="course-description">{description || 'Opis nije dostupan.'}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TopCourses;
