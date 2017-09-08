#include <array>
#include <iostream>

int main()
{
    std::array<char, 10> letters;
    // Not initialized. Print random letter
    std::cout << "Last letter: " << letters[9] << std::endl;
    return 0;
}
