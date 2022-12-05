import React, { useEffect, useState } from 'react'
import { json, useNavigate } from 'react-router-dom'
import {Col, Container, Row, Form, Button, Modal, CloseButton} from 'react-bootstrap'
import {Table} from 'react-bootstrap'
import Popup from 'reactjs-popup'
import Food from './Food'
import Restaurant from './Restaurant'

function User(props) {
    const[userInfo, setUserInfo] = useState('')
    const[restInfo, setrestInfo] = useState([])
    const[foodState, setFoodState] = useState(false)
    const[restid, setRestId] = useState('')
    
    const [show, setShow] = useState(false);

  const handleClose = () => {
    setShow(false);

    window.location.reload()
  }
  const handleShow = () => setShow(true);
    const data = localStorage.getItem("name")
    const navigate = useNavigate()

    console.log(props)

    const fetchUser = () =>{
        fetch(`http://localhost:9090/user/name/${data}`)
        .then(res => res.json())
        .then(response => {
            setUserInfo(response[0])
            setrestInfo(response[0].restaurants)
        })
    }

    useEffect(() =>{
        fetchUser() 
        console.log("in useeffect")
        
    },[props])

    const removeRestaurant = (e) =>{
      console.log(e)
    }

    



    console.log(userInfo)
    console.log(restInfo) 
    
    const signOut = () =>{
        localStorage.setItem("name", "")
        navigate("/")
    }

    const getPdf = () =>{
        
    }

    const addFood = () =>{
        //setFoodState(true)
        console.log("hello")
    }

    

    const deleteRest = (e) =>{
      setRestId(e.target.value)
      console.log(restid)
      fetch(`http://localhost:9090/Restaurant/${restid}`, {method: 'DELETE'})
        .then(res => res.json())
        .then(response => {
          console.log(response)
          window.location.reload()
          console.log('hi')
          })
        

    }

    
    


  return (
    <>
    <Container fluid>
        <Row className='p-3 mb-2 bg-secondary text-white'>
            <Col xs={11}>Welcome {data}!</Col>
            <Col onClick={signOut} id='signout'>Sign out</Col>
        </Row>
    </Container>
    <Container>
        <Row>
        <Table striped bordered hover>
      <thead>
        <tr>
          <th>Restaurant Name</th>
          <th># of menu food</th>
          <th>Food Safety Certification</th>
        </tr>
      </thead>
      <tbody>
        
         {restInfo.map((user) =>(
            <tr>
                
                <td>
                <Button variant="outline-danger" size='sm' id='close-button' value={user.restaurantId} onClick={deleteRest}>X</Button>
                  {user.restaurantName}
                </td>
                <td onClick={addFood}>{user.restFood.length}</td>
                
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
        </Row>
                  <Food data={userInfo} restinfo={restInfo} />
                  <Restaurant data={userInfo} />
                  
                       

    </Container>
</>
  )
}

export default User 