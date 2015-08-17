# FileEncoder

A Java project from FMI for encoding and decoding files.

- Encodes a file with a specified key and saves the result to a given path.
- Decodes a file that was encoded with a specified key and saves the result to a given path.

You have to give a path to a file, which has to be encoded.
You also have to give a path, where to write the resulting file.
Finally, you have a list of 256 bytes, each different from the others.
The task is to implement the encryption and decryption methods described above
using the following algorithm:

```
For i = 0, i < sourceFile.lengthInBytes, i++
    char b = sourceFile[i]
    if i is a prime number or 1:
        write b to the destination file as is
    else:
        write to the destination file the value of the b-th element of the key
```
Here's an example. Let's say you are given the following source file and key:

**Source file**: 4 3 2 0 5...

**Key**: 123 101 111 222 251 42...

Then the output file should start like this:

**Output**: 251 3 2 0 42 ...

For decoding you have to use the same key.

* In the repository are given two example keys to try to encode and decode files.
* Download the repository and run the Main class with your own specific file directions.
