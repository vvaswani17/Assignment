Prerequisites:-
1.scala
2.sbt

how to run:-
1.go inside the CurrencyConversion folder through cmd and type 'sbt runAll' (without single quotes).
-This is a sbt project done by using Lagom framework for api creation.

2.once services are up and running follow below steps to run jar and pass the file name with location.

2.1.place atteched jar file in a specific folder.
2.2.place a json file in a specific folder and copy the location along with file name ,that will be used as input argument in the next step.
2.3.reach out to the folder where CurrencyConverter jar file is avaialable and run below command
java -jar CurrencyConverter.jar C:\test\input.json EUR


#short description of the following characteristics for your solution
● Will it work with a 2 TB input file as well?
-We can use streaming framework for the same but current one may not be the feasible solution for this point.
● What would happen if the input file has one malformed JSON line towards theend of the file?
-It will be ignored.
● Assume your API should degrade gracefully / still be available in case the upstream exchange rate service is down. How would you handle this?
-I can give alternate location for reading the near value ,may be from database or the config file, whereever there is latest data.
-I can also save the recent read rate and can use that one if service fails.


