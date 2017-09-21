# URL Shortener

Aplikacija je odrađena spring boot-om i Java tehnologijom u razvojnom okruženju IntelliJ IDEA - Community edition.

Kreirano je:

- JSON klase - na lokaciji src\main\java\com\nemanja\shortener\model -

ShortenRequestJSON.java - prihvata originalni URL
ShortenResponseJSON.java - kreira key-value par originali - skraceni URL

- end point - ShortenerController.java na lokaciji src\main\java\com\nemanja\shortener\controller

- interfejs - ShortenerService.java na lokaciji src\main\java\com\nemanja\shortener\service

- implementacija interfejsa - ShortenerServiceImpl.java na lokaciji src\main\java\com\nemanja\shortener\service

- aplikacija za SpringBoot koja se prva pokreće i pokreće aplikaciju - ShortenerApplication.java na lokaciji src\main\java\com\nemanja\shortener

- ShortenerInitializer - implementira Spring Boot servlet i omogućava aplikaciji da se deployuje na bilo koji tomcat.


Aplikacija skraćuje URL-ove tako što za dati URL kreira skraćenu verziju, storuje u JSON-u par - dugačka - kratka i pri pozivu gnerisanog skraćenog URL-a,
redirektuje na originalni.

Na primer, pri pozivu URL-a https://www.google.rs/search?q=backend+developer&oq=backend+de&aqs=chrome.0.35i39j69i57j35i39j0l3.4031j0j7&sourceid=chrome&ie=UTF-8
generiše novi URL http://localhost/95UdHJTj, pa pri ponovnom pozivanju http://localhost/95UdHJTj redirektujemo se na originalni https://www.google.rs/search?q=backend+developer&oq=backend+de&aqs=chrome.0.35i39j69i57j35i39j0l3.4031j0j7&sourceid=chrome&ie=UTF-8


UPUTSTVO ZA IMPLEMENTACIJU:

Source kod se nalazi u folderu shortener i .java fajlovi su  na lokacijama src\main\java\com\nemanja\greet\

izvršni i kopajlirani kod se nalazi na lokaciji tomcat/ROOT

PREREQUISITES:

Za source kod - razvojno okruženje IntelliJ

Za kontejnere - CentOS 7 x64, instalirani paketi docker engine i docker compose.
Instalacija se može naći na https://github.com/majstorki88/load_balanser

Za implementaciju je dovoljno pokrenuti komandu docker-compose -f docker-compose.yml iz foldera URL_short
