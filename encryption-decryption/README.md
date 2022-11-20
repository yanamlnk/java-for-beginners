# Project Details

### Stages: 6
1) Print out encrypted message where you replace each letter with the letter that is in the corresponding position from the end of the English alphabet (a→z, b→y, c→x, ... x→c, y →b, z→a). Do not replace spaces or exclamation marks.
2) A program that reads an English message and an integer number (key) from the standard input and shifts each letter by the specified number according to its order in the alphabet. If you reach the end of the alphabet, start back at the beginning (a follows z).
3) Write a program that reads three lines from the standard input: a target operation (enc for encryption, dec for decryption), a message or a cyphertext, and a key to encrypt/decrypt messages. All non-letter characters should be encrypted as well as regular letters.
4) Modify the previous program to work with command-line arguments instead of the standard input.
5) Add the ability to read and write the original and cipher data into files.
6) Extend your program by adding different algorithms for encoding/decoding.

## Task description
Write a program that takes command-line arguments and parse them accordingly. Arguments will be presented as pairs `-key value`:

- `-mode` argument determine program's mode (`enc` for encryption, `dec` for decryption). If there is no `-mode`, the program should work in the `enc` mode.
- `-key` is an integer key to modify the message. If there is no `-key`, the program should consider that it is `0`.
- `-data` is a text or ciphertext to encrypt/decrypt. If there is no `-data`, the program should assume that data is an empty string.
- `-in` -  to specify the full name of a file to read the data. Your program should read data from `-data` or from a file specified in the `-in` argument. That's the reason why you can't have both `-data` and `-in` arguments simultaneously. If there is no `-data` and no `-in` the program should assume that the data is an empty string. If there are both `-data` and `-in` arguments, your program should prefer `-data` over `-in`.
- `-out` - to specify the full name of a file to write the result. If there is no `-out` argument, the program must print data to the standard output.
- `-alg` - to specify algorithm for encoding/decoding (`shift` or `unicode`). If there is no `-alg` argument, default it to `shift`. 

Keep in mind that the order of the arguments might be different. For example, `-mode enc` maybe at the end, at the beginning, or in the middle of the array.

If there is something strange (an input file does not exist, or an argument doesn't have a value), the program should not fail. Instead, it must display a clear message about the problem and stop successfully. The message should contain the word `Error`. 

## Test Case

**Example 1**: -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode

_This command must get data from `road_to_treasure.txt`, `encrypt` the data with the key of `5`, create `protected.txt`, and write ciphertext into it._

**Example 2**: -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode

`\jqhtrj%yt%m~ujwxpnqq&`

**Example 3**: -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec

`Welcome to hyperskill!`

**Example 4**: -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc

`Bjqhtrj yt mdujwxpnqq!`

**Example 5**: -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec

`Welcome to hyperskill!`

# Code Details

## Input
`main(String[] args)`

Program takes input as command-line arguments. Example of input:
```
-key 5 -alg shift -data "Welcome to hyperskill!" -mode enc
```
The text to encrypt/decrypt can be given to the program either in a file, using `-in` argument, or as a String, using `-data` argument.

## Output
Depending on the initial arguments, output can be either in a form of a file (using `-out` argument) or as a standart output (`System.out.print`).

## Topics used for this task

- **Design Patterns** - simple factory (`Factory` class that depending on the `-alg` creates instance of either `Shift` class or `Unicode`)  and template method(`Shift` and `Unicode` classes extend abstract class `Cypher`)
- **Abstract class**
- Working with **command-line arguments**
- **Files** - reading, writing and creating files
