import React, { useEffect, useState } from 'react'
import { Col, Container, Row, Form, Button, Modal } from 'react-bootstrap'


function Restaurant(props) {
    const [show, setShow] = useState(false);
    const [restInfo, setrestInfo] = useState([])
    const [info, setInfo] = useState()
    const [value, setValue] = useState([])
    const [validated, setValidated] = useState(false);
    const [rest, setRest] = useState('')
    const [pdf, setPdf] = useState('')
    const [file, setFile] = useState([])
    const [test, setTest] = useState([])

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
    
    const fileToBase64 = (file, cb) => {
        const reader = new FileReader()
        reader.readAsDataURL(file)
        reader.onload = () =>{
            cb(null, reader.result)
        }
        reader.onerror = (error) =>{
            cb(error, null)
        }
    }

    const fetchRest = async () => {
    
        await fetch(`http://localhost:9090/addrestaurant/${info.id}`, requestOptions)
          .then(response => response.json())
          .then(res => {
            setFile(res);
            setValidated(false);
            handleClose();
            
            const formData = new FormData()
            formData.append("file", pdf)
            return fetch(`http://localhost:9090/addpdf/${info.id}`, {
                method: 'POST',
                body: formData
            })
            //res.restaurants[num].restaurantId
            
            
          })
          .then(response => response.json())
          .then(data => {
            setTest(data)
          })
      }
    
    //   const onUploadFileChange = ({ target }) => {
    //     if (target.files < 1 || !target.validity.valid) {
    //       return
    //     }
    //     fileToBase64(target.files[0], (err, result) => {
    //       if (result) {
    //         setFile(result)
    //       }
    //     })
    //   }

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
                                    <Form.Control type="file" onChange={e => setPdf(e.target.files[0])} required/>
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