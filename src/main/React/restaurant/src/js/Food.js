
import React, { useEffect, useState } from 'react'

import { Col, Container, Row, Form, Button, Modal } from 'react-bootstrap'
import Users from './User'


function Food(data) {
  const [show, setShow] = useState(false);
  const [foodName, setFoodName] = useState('')
  const [foodPrice, setFoodPrice] = useState('')
  const [foodType, setFoodType] = useState('')
  const [userInfo, setUserInfo] = useState('')
  const [restInfo, setrestInfo] = useState([])
  const [value, setValue] = useState([])
  const [validated, setValidated] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  useEffect(() => {
    setUserInfo(data.data)
    setrestInfo(data.restinfo)
  }, [data])

  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      foodType: foodType,
      foodName: foodName,
      foodPrice: foodPrice
    }) 
  }

  console.log(value)
  const fetchRest = () => {
    
    fetch(`http://localhost:9090/addfood/${value}`, requestOptions)
      .then(response => response.json())
      .then(res => {
        setValidated(false);
        handleClose();
        console.log(restInfo)
        window.location.reload();
      })
  }

  const getValue = (e) =>{
    setValue(e.target.value)
  }

  const handleSubmit = (event) => {
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
    }
    
    fetchRest();
    <Users props={setShow}/>
    setValidated(true);
  };

  return (
    <>
      <Button variant="secondary" onClick={handleShow}>
        Add Food
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
        </Modal.Header>
        <Modal.Body>
          <Form noValidate validated={validated} onSubmit={handleSubmit}>
            <Row>
              <Col xs={4} className='select'>
                <Form.Select aria-label="Default select example"  onChange={getValue}>
                  {restInfo.map((info) => {
                    return <option value={info.restaurantId}>{info.restaurantName}</option>
                  })}
                </Form.Select>
              </Col>
              <Col>
                <Form.Group className='mb-3' controlId='foodName'>
                  <Form.Label>Food Name</Form.Label>
                  <Form.Control type='name' placeholder='Pizza' onChange={e => setFoodName(e.target.value)} required />
                </Form.Group>
              </Col>
              <Col>
                <Form.Group className='mb-3' controlId='foodPrice'>
                  <Form.Label>Food Price</Form.Label>
                  <Form.Control type='name' placeholder='3.99' onChange={e => setFoodPrice(e.target.value)} required />
                </Form.Group>
              </Col>
              <Col>
                <Form.Group className='mb-3' controlId='foodType'>
                  <Form.Label>Food Type</Form.Label>
                  <Form.Control type='name' placeholder='Dinner' onChange={e => setFoodType(e.target.value)} required />
                </Form.Group>
              </Col>
            </Row>

          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSubmit}>
            Save Changes
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default Food