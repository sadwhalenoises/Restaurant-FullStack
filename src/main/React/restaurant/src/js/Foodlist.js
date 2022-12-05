import { Col, Container, Row, Form, Button, Modal, Table } from 'react-bootstrap'
import React, { useEffect, useState } from 'react'

function Foodlist(props) {
    const[userInfo, setUserInfo] = useState('')
    const[restInfo, setrestInfo] = useState([])
    const [show, setShow] = useState(false);

    const handleSubmit = (event) => {
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
      };

      useEffect(() => {
        setUserInfo(props.data)
        setrestInfo(props.restinfo)
      }, [setShow])

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  
  return (
    <>
        <Button variant="secondary" onClick={handleShow}>
        Add Food
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
        </Modal.Header>
        <Modal.Body>
        <Table striped bordered hover>
      <thead>
        <tr>
          <th>Food Name</th>
          <th>Type</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
        
         {restInfo.map((user) =>(
            <tr>
                
                <td>
                  {user.restaurantName}
                </td>
                <td>{user.restFood.length}</td>
                
                <td>{user.pdf ? getPdf() : 'No pdf'}</td>
            </tr>
        ))} 
        {/* <tr>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr> */}
      </tbody>
    </Table>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  )
}

export default Foodlist