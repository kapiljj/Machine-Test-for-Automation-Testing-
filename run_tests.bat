@echo off
echo Running Calley Team Account Automation Tests...

echo 1. Setting up environment...
set CLASSPATH=.

REM Add all jar files in the project lib directory
for %%f in (.\lib\*.jar) do call :append_classpath %%f

echo 2. Compiling the code...
javac -d target\classes src\main\java\com\calley\utils\*.java src\main\java\com\calley\config\*.java src\main\java\com\calley\pages\*.java
javac -cp target\classes;%CLASSPATH% -d target\test-classes src\test\java\com\calley\utils\*.java src\test\java\com\calley\tests\*.java

echo 3. Running the Registration test...
java -cp target\classes;target\test-classes;%CLASSPATH% org.testng.TestNG testng.xml

echo Tests completed. Check results above.
goto :eof

:append_classpath
set CLASSPATH=%CLASSPATH%;%1
goto :eof 