# Introduction
This software is used to solve the SalesTaxes problem. I apply different taxes (basic taxes and import duties) to the products, some products are extempted from basic taxes (like food, medical products and books), then I print the resulting receipt of the purchase.

# Compile
To run the tests, you will need to use this command line in the main folder of this program : `mvn test`.
To compile the main program, from the main folder, use this command line : `javac -cp ./src/main/java -d ./target ./src/main/java/Main.java`.
The result of the compilation will be available in the "target" folder, from that folder, to run the program, you will need to type this command line: `java -cp ../src/main/java; Main`.