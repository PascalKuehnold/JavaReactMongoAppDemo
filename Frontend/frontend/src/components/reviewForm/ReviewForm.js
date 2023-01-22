import React, { useState } from "react";
import { Form, Button, Alert } from "react-bootstrap";

const ReviewForm = ({ handleSubmit, labelText, defaultValue }) => {
  const [reviewText, setReviewText] = useState(""); 
  const [showError, setShowError] = useState(false);

  function onSubmitHandler(e) {
    e.preventDefault();

    if(reviewText.trim() === ""){
      setReviewText(reviewText.trim())
      setShowError(true);
      return;
    }

    handleSubmit(reviewText.trim())

    setReviewText("");
    setShowError(false);
  }

  
  return (
    <Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
        <Form.Label>{labelText}</Form.Label>
        <Form.Control
          as="textarea"
          rows={3}
          defaultValue={defaultValue}
          onChange={(e) => setReviewText(e.target.value)}
          value={reviewText}
        />
      </Form.Group>
      {showError && <Alert variant="danger">Please enter a message.</Alert>}
      <Button variant="outline-info" onClick={onSubmitHandler}>
        Submit
      </Button>
    </Form>
  );
};

export default ReviewForm;
