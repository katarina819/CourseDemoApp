import React, { useEffect, useState } from 'react';

function CoursesPage() {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/courses')
      .then(response => response.json())
      .then(data => setCourses(data))
      .catch(error => console.error('Greška pri dohvaćanju tečajeva:', error));
  }, []);

  return (
    <div style={{ padding: '20px' }}>
      <h1>Popis Tečajeva</h1>
      {courses.length === 0 ? (
        <p>Učitavanje...</p>
      ) : (
        <ul>
          {courses.map(course => (
            <li key={course.id} style={{ marginBottom: '15px' }}>
              <h3>{course.title}</h3>
              <p>{course.description}</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default CoursesPage;
