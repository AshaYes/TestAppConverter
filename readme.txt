Distance Unit Conversion Application
Task:
Develop an application for converting between units of distance with support for both metric and imperial measurement systems. Conversion ratios can be taken from a table. 
By default, the application should recognize meters (m), centimeters (cm), inches (in), and feet (ft), and support conversion between any units. Additionally, 
it's necessary to implement the ability to extend the list of supported units by specifying conversion rules through a JSON file. The JSON file format is at your discretion. 
For example, extend your application by adding values for millimeters (mm), yards (yd), and kilometers (km) to the file.

Input Parameters:
A JSON object containing the distance to be converted (distance) with a value (value) and a unit scale (unit), as well as the designation of the unit to which the conversion should be made (convert_to). For example:

{"distance": {"unit": "m", "value": 0.5}, "convert_to": "ft"}

Output Data:
A JSON object containing the converted distance value rounded to two decimal places, along with the designation of the corresponding unit of measurement. For example:

{"unit": "ft", "value": 1.64}

How to Use:
Ensure you have Java installed on your system.
Clone this repository to your local machine.
Compile and run the application using your preferred Java IDE or build tools.
Use the provided JSON input format to specify the distance to be converted and the desired unit for conversion.
Receive the converted distance value in the specified unit as the output.
Extending Supported Units:
To extend the list of supported units, modify the JSON configuration file according to your requirements, adding new units and their conversion ratios as needed. The application will automatically recognize and apply these additional units for conversion.

Example:
Input:

{"distance": {"unit": "m", "value": 0.5}, "convert_to": "ft"}

Output:

{"unit": "ft", "value": 1.64}
