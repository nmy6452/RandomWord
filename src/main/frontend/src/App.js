import Home from './pages/Home';
import List from './pages/List';
import Edit from './pages/Edit';
//스타일 임포트
import 'bootstrap/dist/css/bootstrap.min.css';
//네비게이션 관련 import
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import {LinkContainer} from 'react-router-bootstrap'
//라우트
import { Routes, Route } from 'react-router-dom';
import './App.css';
// import React, {useEffect, useState} from 'react';
// import { createStore } from 'redux'


function App() {
  return (
    <div className="App">
      <header className="App-header">
          <Navbar bg="dark" data-bs-theme="dark">
            <Container>
            <LinkContainer to="/">
              <Navbar.Brand>Navbar</Navbar.Brand>
            </LinkContainer>
              <Nav className="me-auto">
                <LinkContainer to="/">
                  <Nav.Link>Home</Nav.Link>
                </LinkContainer>
                <LinkContainer to="/List">
                  <Nav.Link>List</Nav.Link>
                </LinkContainer>
                <LinkContainer to="/Edit">
                  <Nav.Link>Edit</Nav.Link>
                </LinkContainer>
              </Nav>
            </Container>
          </Navbar>
        <Routes>
            <Route path='/' element={<Home />}/>
            <Route path='/List' element={<List />}/>
            <Route path='/Edit' element={<Edit />}/>
        </Routes>
      </header>
    </div>
  );
}

export default App;
