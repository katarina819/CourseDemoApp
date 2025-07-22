// src/HomePage.js
import React from 'react';
import { useNavigate } from 'react-router-dom';
import './HomePage.css';

function HomePage() {
  const navigate = useNavigate();

  return (
    <div className="homepage-container">
      <img
        src="/images/slika1.jpg" // slika mora biti u public/images/
        alt="programming"
        className="hero-image"
      />

      <div className="content-section">
        <h1>Dobrodošli na e - tečajeve</h1>
        <p>Nauči programirati i započni svoju IT karijeru!</p>
        <div className="button-group">
          <button onClick={() => navigate('/courses')}>
            Pogledaj aktivne tečajeve
          </button>
          <button onClick={() => navigate('/top-courses')}>
            Ne znaš šta odabrati? Pogledaj top 10 zanimanja
          </button>
        </div>
      </div>
    </div>
  );
}

export default HomePage;
