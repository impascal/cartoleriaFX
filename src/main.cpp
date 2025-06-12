#include <SFML/Graphics.hpp>
#include <vector>

#include "config.hpp"
#include "particle.hpp"


int main(int argc, char** argv)
{

    sf::RenderWindow window(sf::VideoMode({w_width, w_heigth}), "Particle Simulator!");
    window.setFramerateLimit(fps);

    // vector of particles 
    std::vector<Particle> particles;
    particles.insert(particles.end(), Particle(400, 300));

    while (window.isOpen())
    {
        // event handling loop
        while (const std::optional event = window.pollEvent())
        {
            if (event->is<sf::Event::Closed>())
                window.close();
        }

        // update state
        for(Particle& p : particles)
            p.update();

        // start drawing
        window.clear(sf::Color::White);
        
        // draw all particles
        for(Particle& p : particles) {
            p.draw(&window);
        }

        // display drawing 
        window.display();
    }
}