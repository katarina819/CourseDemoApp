import React, { useEffect, useState } from 'react';
import CourseModal from './CourseModal';
import './CoursesList.css';
import { useNavigate } from 'react-router-dom';

function CoursesList() {
  const [products, setProducts] = useState([]);
  const [selectedCourse, setSelectedCourse] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const navigate = useNavigate();
  

  useEffect(() => {
  fetch(`${process.env.REACT_APP_BACKEND_URL}/products`, {
    credentials: 'include'
  })
    .then(res => {
      if (!res.ok) throw new Error(`HTTP error! status: ${res.status}`);
      return res.json();
    })
    .then(data => setProducts(data))
    .catch(err => console.error(err))
    .finally(() => setIsLoading(false));
}, []);




if (isLoading) {
  return (
    <div className="loading-container">
      <h3>Tečajevi se učitavaju... Zaigraj nešto u međuvremenu! 🎮</h3>
      <div className="game-wrapper">
        <iframe
          src="/dino.html"
          title="Mini igra"
        />
      </div>
    </div>
  );
}

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
    <div className="back-button-container">
  <button
    onClick={() => navigate('/')}
    className="back-button"
  >
    ⬅️ Natrag na početnu
  </button>
</div>
</div>  
  );
}

export default CoursesList;
