#ifndef PARTICLE_HPP
#define PARTICLE_HPP

#include <SFML/Graphics.hpp>
#include <SFML/System.hpp>
#include "config.hpp"

class Particle{

    private:

    protected:

        double mass; 
        double radius;

        sf::Vector2f position;
        sf::Vector2f velocity;
        sf::Vector2f acceleration;

    public:

        Particle(float x, float y);
        Particle() { Particle(0, 0); }

        void update();
        void draw(sf::RenderWindow* window);

        double getMass() { return mass; }
        double getRadius() { return radius; }
        sf::Vector2f getPosition() { return position; }
        sf::Vector2f getVelocity() { return velocity; }
        sf::Vector2f getAcceleration() { return acceleration; }

        
};

#endif