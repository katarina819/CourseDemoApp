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
        
        <Route path="/courses" element={<CoursesList />} />
        
        <Route path="/courses-simple" element={<CoursesPage />} /> 
         <Route path="/top-courses" element={<TopCourses />} />  
      </Routes>
    </Router>
  );
}

export default App;
