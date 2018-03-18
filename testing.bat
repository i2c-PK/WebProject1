set projectLocation=C:\Users\Administrator\eclipse-workspace\WebProject1
cd %projectLocation%
set classpath=%projectLocation%\target\test-classes;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml