import React from 'react'
import { Card, Button } from 'react-bootstrap'
import { Link } from 'react-router-dom'


const NotFound = () => {
  return (
    <Card className='text-center'>
    <Card.Body>
        <Card.Title style={{color: 'black'}}>Page not found</Card.Title>
        <Card.Subtitle className="mb-2 text-muted">Couldn't find the page you are looking for.</Card.Subtitle>
        <Link to={"/"}> 
            <Button variant="primary">Go to main page</Button>
        </Link>
    </Card.Body>
    </Card>
  )
}

export default NotFound