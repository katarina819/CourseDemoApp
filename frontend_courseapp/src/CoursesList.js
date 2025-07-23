import React, { useEffect, useState } from 'react';
import CourseModal from './CourseModal';
import './CoursesList.css';

function CoursesList() {
  const [products, setProducts] = useState([]);
  const [selectedCourse, setSelectedCourse] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [currentMessageIndex, setCurrentMessageIndex] = useState(0);
  const [fade, setFade] = useState(false);

  const loadingMessages = [
    "⌛ Učitavamo tečajeve...",
    "⏳ Molimo pričekajte max 3 min...",
    "⏰ Još malo pa će se učitati...",
    "🚀 Ubrzo stiže popis aktivnih tečajeva na koje se možete prijaviti...",
    "📋 Popis tečajeva stiže..."
  ];
  

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


useEffect(() => {
    if (!isLoading) return;

    const interval = setInterval(() => {
      // prvo fade out
      setFade(true);

      // nakon 1s (vrijeme trajanja fade out) promijeni poruku i fade in
      setTimeout(() => {
        setCurrentMessageIndex(prevIndex =>
          (prevIndex + 1) % loadingMessages.length
        );
        setFade(false);
      }, 1000);  // mora biti isto kao CSS trajanje fadea
    }, 4000); // svake 4 sekunde se mijenja poruka

    return () => clearInterval(interval);
  }, [isLoading]);

if (isLoading) {
    return (
      <div className="loading-container">
        <div className="spinner"></div>
        <p className={`loading-message ${fade ? "fade-out" : ""}`}>
          {loadingMessages[currentMessageIndex]}
        </p>
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
    </div>
  );
}

export default CoursesList;
