import React from "react";
import { Row, Col } from "react-bootstrap";

const Review = (props) => {
  const review = props.review;

  return (
    <Row>
      <Col>{review.body}</Col>
    </Row>
  );
};

export default Review;
