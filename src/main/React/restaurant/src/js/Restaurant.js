import React, { useEffect, useState } from 'react'
import { Col, Container, Row, Form, Button, Modal } from 'react-bootstrap'


function Restaurant(props) {
    const [show, setShow] = useState(false);
    const [restInfo, setrestInfo] = useState([])
    const [info, setInfo] = useState()
    const [value, setValue] = useState([])
    const [validated, setValidated] = useState(false);
    const [rest, setRest] = useState('')

    console.log(props.data)
    useEffect(() => {
        setrestInfo(props.data.restaurants)
        setInfo(props.data)
    })
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const getValue = (e) => {
        setValue(e.target.value)
    }

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          restaurantName: rest
        }) 
      }

    const fetchRest = () => {
    
        fetch(`http://localhost:9090/addrestaurant/${info.id}`, requestOptions)
          .then(response => response.json())
          .then(res => {
            setValidated(false);
            console.log(res);
            handleClose();
            window.location.reload();
            
            
          })
      }

    const handleSubmit = (event) => {
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        }
        fetchRest();
        setValidated(true);
    };

    return (
        <>
            <Button variant="secondary" onClick={handleShow} className='restButton'>
                Add Restaurant
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                </Modal.Header>
                <Modal.Body>
                    <Form noValidate validated={validated} onSubmit={handleSubmit}>
                        <Row>
                            <Col xs={4} className='select'>
                                
                                <Form.Group className='mb-3' controlId='foodPrice'>
                                    <Form.Label>Restaurant Name </Form.Label>
                                    <Form.Control type='name' placeholder='Pizza Hut' onChange={e => setRest(e.target.value)} required />
                                </Form.Group>
                            </Col>
                            <Col>
                                <Form.Group controlId="formFile" className="mb-3">
                                    <Form.Label>Default file input example</Form.Label>
                                    <Form.Control type="file" />
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

export default Restaurant