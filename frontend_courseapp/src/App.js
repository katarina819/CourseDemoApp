// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './HomePage';
import CoursesList from './CoursesList';
import CoursesPage from './CoursesPage'; 
import TopCourses from './TopCourses'; 

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        {/* ovo zamijeni s CoursesList da ti se prikazuje na /courses */}
        <Route path="/courses" element={<CoursesList />} />
        {/* ako ti treba, možeš courses-simple ostaviti ili obrisati */}
        <Route path="/courses-simple" element={<CoursesPage />} /> 
         <Route path="/top-courses" element={<TopCourses />} />  
      </Routes>
    </Router>
  );
}

export default App;
