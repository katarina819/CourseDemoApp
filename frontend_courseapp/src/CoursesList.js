import React, { useEffect, useState } from 'react';
import CourseModal from './CourseModal';
import './CoursesList.css';

function CoursesList() {
  const [products, setProducts] = useState([]);
  const [selectedCourse, setSelectedCourse] = useState(null);

  useEffect(() => {
    fetch('http://localhost:8080/products', {
      credentials: 'include'
    })
      .then(res => {
        if (!res.ok) throw new Error(`HTTP error! status: ${res.status}`);
        return res.json();
      })
      .then(data => setProducts(data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div className="courses-container">
      <h1>Online Tečajevi</h1>
      <div className="courses-grid">
        {products.map((course) => {
          const {
            id,
            name = "Bez naziva",
            description = "Bez opisa",
            image,
            priceCentAmount,
            priceCurrencyCode,
            startDate = "2025-09-01",
            duration = "8 tjedana"
          } = course;

          return (
            <div className="course-card" key={id}>
              {image && <img src={image} alt={name} />}
              <h2>{name}</h2>
              <p>{description.length > 150 ? description.slice(0, 150) + "..." : description}</p>
              {priceCentAmount != null && (
                <p className="price">
                  Cijena: {(priceCentAmount / 100).toFixed(2)} {priceCurrencyCode}
                </p>
              )}
              <button
                onClick={() =>
                  setSelectedCourse({
                    name,
                    description,
                    image,
                    priceCentAmount,
                    priceCurrencyCode,
                    startDate,
                    duration
                  })
                }
              >
                Prijavi se
              </button>
            </div>
          );
        })}
      </div>

      <CourseModal
        course={selectedCourse}
        onClose={() => setSelectedCourse(null)}
      />
    </div>
  );
}

export default CoursesList;
