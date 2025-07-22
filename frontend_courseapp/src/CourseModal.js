import React, { useState, useEffect } from 'react';
import './CourseModal.css';
import courseDetailsMap from './courseDetailsMap';

function CourseModal({ course, onClose }) {
  const [showPaymentForm, setShowPaymentForm] = useState(false);
  const [success, setSuccess] = useState(false);
  const [errors, setErrors] = useState({});
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    cardNumber: '',
    expiry: '',
    cvv: ''
  });

  // ⬇️ RESETIRAJ STANJE svaki put kad se otvori novi tečaj
  useEffect(() => {
    setShowPaymentForm(false);
    setSuccess(false);
    setErrors({});
    setFormData({
      firstName: '',
      lastName: '',
      email: '',
      cardNumber: '',
      expiry: '',
      cvv: ''
    });
  }, [course]);

  if (!course) return null;

  const { name, description, priceCentAmount, priceCurrencyCode } = course;
  const details = courseDetailsMap[course.name.trim()];

  const handleChange = (e) => {
    setFormData(prev => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const validateForm = () => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const cardRegex = /^\d{16}$/;
    const cvvRegex = /^\d{3}$/;
    const expiryRegex = /^(0[1-9]|1[0-2])\/\d{2}$/;

    const newErrors = {};

    if (!formData.firstName.trim()) newErrors.firstName = "Ime je obavezno.";
    if (!formData.lastName.trim()) newErrors.lastName = "Prezime je obavezno.";
    if (!emailRegex.test(formData.email)) newErrors.email = "Email nije ispravan.";
    if (!cardRegex.test(formData.cardNumber)) newErrors.cardNumber = "Broj kartice mora imati 16 znamenki.";
    if (!expiryRegex.test(formData.expiry)) {
      newErrors.expiry = "Format mora biti MM/YY (npr. 01/26).";
    }
    if (!cvvRegex.test(formData.cvv)) newErrors.cvv = "CVV mora imati 3 znamenke.";

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handlePayment = (e) => {
    e.preventDefault();

    if (!validateForm()) return;

    setTimeout(() => {
      setSuccess(true);
    }, 1000);
  };

  return (
    <div className="modal-backdrop" onClick={onClose}>
      <div className="modal-content" onClick={e => e.stopPropagation()}>
        <button className="close-btn" onClick={onClose}>X</button>

        {/* Prikaz detalja */}
        {!showPaymentForm && !success && (
          <>
            <h2>{name}</h2>
            <p>{description}</p>

            {priceCentAmount != null && (
              <p><strong>Cijena:</strong> {(priceCentAmount / 100).toFixed(2)} {priceCurrencyCode}</p>
            )}

            {details ? (
              <>
                <p><strong>Početak:</strong> {details.startDate}</p>
                <p><strong>Trajanje:</strong> {details.duration}</p>
              </>
            ) : (
              <p><em>Nema dostupnih detalja o početku i trajanju.</em></p>
            )}

            <button className="buy-btn" onClick={() => setShowPaymentForm(true)}>
              Kupi
            </button>
          </>
        )}

        {/* Forma za plaćanje */}
        {showPaymentForm && !success && (
          <form onSubmit={handlePayment} className="payment-form">
            <h3>Podaci za kupnju</h3>

            <label>Ime:</label>
            <input name="firstName" onChange={handleChange} />
            {errors.firstName && <p className="error-text">{errors.firstName}</p>}

            <label>Prezime:</label>
            <input name="lastName" onChange={handleChange} />
            {errors.lastName && <p className="error-text">{errors.lastName}</p>}

            <label>Email:</label>
            <input name="email" type="email" onChange={handleChange} />
            {errors.email && <p className="error-text">{errors.email}</p>}

            <label>Broj kartice:</label>
            <input name="cardNumber" onChange={handleChange} />
            {errors.cardNumber && <p className="error-text">{errors.cardNumber}</p>}

            <label>Datum isteka (MM/YY):</label>
            <input name="expiry" onChange={handleChange} />
            {errors.expiry && <p className="error-text">{errors.expiry}</p>}

            <label>CVV:</label>
            <input name="cvv" onChange={handleChange} />
            {errors.cvv && <p className="error-text">{errors.cvv}</p>}

            <button type="submit">Plati</button>
          </form>
        )}

        {/* Uspješno plaćanje */}
        {success && (
          <div className="success-message">
            <h3>Uspješno ste platili!</h3>
            <p>Upisani ste na tečaj: <strong>{name}</strong></p>
            <button onClick={onClose}>Zatvori</button>
          </div>
        )}
      </div>
    </div>
  );
}

export default CourseModal;
