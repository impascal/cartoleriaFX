# --- User-definable Variables ---
# Compiler to use (g++ from MinGW)
CXX := g++

# Build directory for object files and the final executable
BUILD_DIR := build

# Source directory
SRC_DIR := src

# Include directory for your own headers
INCLUDE_DIR := include

# Name of your executable
TARGET := bin/particle_sim.exe

# Directory containing linkable libraries
LIB_DIR := lib

# SFML components you are using
# Use -s for static linking (e.g., -lsfml-graphics-s)
# Or omit -s for dynamic linking (e.g., -lsfml-graphics)
# STATIC LINKING EXAMPLE:
LIBS := -lsfml-graphics -lsfml-window -lsfml-system -lopengl32 -lwinmm -lgdi32 -lws2_32

# DYNAMIC LINKING EXAMPLE (uncomment and replace if using dynamic):
# LIBS_SFML := -lsfml-graphics -lsfml-window -lsfml-system

# --- Internal Variables (usually don't need to change) ---
# Find all .cpp files in the source directory
SRCS := $(wildcard $(SRC_DIR)/*.cpp)

# Generate object file names in the build directory
OBJS := $(patsubst $(SRC_DIR)/%.cpp, $(BUILD_DIR)/%.o, $(SRCS))

# Compiler flags
# -I: Add include paths
# -std=c++17: Use C++17 standard (adjust as needed, e.g., c++14)
# -Wall -Wextra: Enable common warnings
# -g: Include debug information
# -DSFML_STATIC: Essential for static linking of SFML on Windows
CXXFLAGS := -I$(INCLUDE_DIR) -std=c++17 -Wall -Wextra -g -DSFML_STATIC

# Linker flags
# -L: Add library paths
# -lsfml-*: Link SFML libraries
LDFLAGS := -L$(LIB_DIR) $(LIBS)

# --- Build Rules ---

.PHONY: all clean run

all: $(BUILD_DIR) $(TARGET)

$(BUILD_DIR):
	@mkdir $(BUILD_DIR) 2>NUL || set /p nul= # Creates directory, suppresses error if exists

$(TARGET): $(OBJS)
	$(CXX) $(OBJS) $(LDFLAGS) -o $@

$(BUILD_DIR)/%.o: $(SRC_DIR)/%.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

clean:
	@del /S /Q $(BUILD_DIR)\*.* 2>NUL
	@rmdir $(BUILD_DIR) 2>NUL
	@del $(TARGET) 2>NUL

run: all
	$(TARGET)