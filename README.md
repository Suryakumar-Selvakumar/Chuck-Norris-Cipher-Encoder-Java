# Chuck Norris Cipher Encoder

This project is an implementation of the Chuck Norris Cipher, a fun way to encode and decode text using only zeros and
spaces. The program was built incrementally, with each stage introducing a new capability:

1. **Stage 1 - Analyze the words:**  
   Prompt the user for input and output every character of the string separated by spaces, including whitespace and
   punctuation.

2. **Stage 2 - The binary world:**  
   Convert each character into its 7-bit binary ASCII form and display it in the format `<char> = <binary>`.

3. **Stage 3 - Chuck Norris encrypts only with zeros:**  
   Transform the binary sequence into the Chuck Norris Unary Cipher, encoding runs of bits into blocks of zeros.

4. **Stage 4 - Try to understand it:**  
   Write a decoder that takes an encoded string and reconstructs the original binary, then converts it back into text.

5. **Stage 5 - Cooler than Chuck Norris:**  
   Finish the program with a user interface that repeatedly asks the user whether they want to encode, decode, or exit.
   Handle invalid operations gracefully and validate encoded strings with proper error messages.

## Demo

<video width="1920" height="1080" align="center" src="https://github.com/user-attachments/assets/5d0608e6-7e27-4e9b-bf08-580666803fa9"></video>


## Takeaway

This project strengthened my ability to work with binary representations, string parsing, and validation logic in Java.
I practiced building both an encoder and decoder, which gave me deeper insight into how data transformations can be
designed in pairs. The iterative stages helped me focus on stepwise problem-solving, and by the end, I had also improved
my skills in user interaction design by creating a looping interface with error handling. Overall, this project pushed
me to think more critically about data integrity and reversibility in encoding schemes. 
