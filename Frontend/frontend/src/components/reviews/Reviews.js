import React, { useEffect, useRef } from "react";
import { Container, Row, Col } from "react-bootstrap";
import { useParams } from "react-router-dom";
import api from "../../api/axiosConfig";
import ReviewForm from "../reviewForm/ReviewForm";
import Review from "./Review";

const Reviews = ({ getMovieData, movie, reviews, setReviews }) => {
  let params = useParams();
  const movieId = params.movieId;

  useEffect(() => {
    getMovieData(movieId);
  }, []);

  const addReview = async (rev) => {

    try {
      const response = await api.post("/api/v1/reviews", {
        reviewBody: rev,
        imdbId: movieId,
      });

      const updatedReviews = [...reviews, { body: rev }];

      setReviews(updatedReviews);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <Container>
      <Row>
        <Col>
          <h3>Reviews</h3>
        </Col>
      </Row>
      <Row className="mt-2">
        <Col>
          <img src={movie?.poster} alt="" />
        </Col>
        <Col>
          {
            <>
              <Row>
                <Col>
                  <ReviewForm
                    handleSubmit={addReview}
                    labelText="Write a Review?"
                  />
                </Col>
              </Row>
              <Row>
                <Col>
                  <hr />
                </Col>
              </Row>
            </>
          }
          {reviews?.map((review) => {
            return (
              <Review review={review} key={reviews.indexOf(review)}/>
            );
          })}
        </Col>
      </Row>
      <Row>
        <Col>
          <hr />
        </Col>
      </Row>
    </Container>
  );
};

export default Reviews;
