#include <SFML/Graphics.hpp>
#include <iostream>
#include "particle.hpp"

Particle::Particle(float x, float y) {

    mass = particle_mass;
    radius = particle_radius;

    // initial position 
    this->position.x = x;
    this->position.y = y;

    // initial velocity 0
    this->velocity.x = 0.0;
    this->velocity.y = 0.0;

    // initial acceleration 0
    this->acceleration.x = 0;
    this->acceleration.y = 9.81;
            
}

void Particle::update() {

    if(position.x - radius <= 0 || position.x + radius >= w_width) {
        velocity.x = -velocity.x;
    }

    if(position.y - radius <= 0 || position.y + radius >= w_heigth) {
        velocity.y = -velocity.y;
    }


    this->position.x += velocity.x * dt + 0.5f * acceleration.x * dt * dt;
    this->position.y += velocity.y * dt + 0.5f * acceleration.y * dt * dt;
    
    this->velocity.x += acceleration.x * dt;
    this->velocity.y += acceleration.y * dt;
}

void Particle::draw(sf::RenderWindow* window) {

    sf::CircleShape shape;
            
    // in SFML the CircleShape position is the high-left "angle" of 
    // the circle and so we have to calculate it from the center we
    // are using in calculations in the back.
    shape.setPosition(this->getPosition());
    shape.move(sf::Vector2f(-this->getRadius()*0.707,
                            -this->getRadius()*0.707));

    // some shape parameters 
    shape.setRadius(this->getRadius());
    shape.setFillColor(sf::Color::White);
    shape.setOutlineColor(sf::Color::Black);
    shape.setOutlineThickness(2);
    
    // actual drawing 
    window->draw(shape);
}
 