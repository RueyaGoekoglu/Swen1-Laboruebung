# Readme

BMI Calculator - a simple gui application calculating the body mass index.

- start application: `mvn clean compile exec:java`

# Aufgabe zum Continuous Buildmanagement


- Einen strukturierten Prozess zur Behandlung von Bugs (Fehlern) verstehen und anwenden bzw. durchführen können.
- Git verwenden, um Bugs im Code zu dokumentieren, zu beheben und zu verwalten.
- Maven und GitLab CI/CD nutzen, um den Fix automatisiert zu testen und zu deployen.
- In einem Team-Workflow arbeiten und die Prinzipien von CI/CD praktisch umsetzen.


## Übung: Bughandling mit Git, Maven und GitLab CI/CD

Ziel der Übung

Lernen, wie man einen Bug in einem bestehenden Projekt identifiziert, behebt, dokumentiert und die erarbeitete Lösung durch Continuous Integration (CI) automatisiert testet. Die Übung soll außerdem den Workflow im Team verdeutlichen und etablierte Best Practices im Umgang mit einer Versionskontrolle (git) , einem Build-Management (maven) und automatisiertem Testing fördern.


### Aufgabenbeschreibung

Du arbeitest an einem Java-Projekt, das eine einfache Berechnung des Body-Mass-Index durchführt und den Endanwendern durch eine Swing-basierte GUI visualisiert. Das Projekt enthält eine falsche Berechnung des BMI. Zudem werden ungültige Angaben zur Grösse und Gewicht nicht validiert. Dein Ziel ist es, den Bug zu finden, zu dokumentieren und mithilfe von Git, Maven und GitLab CI/CD zu beheben und mit Unit Tests abzusichern. Zudem sollst du überprüfen, ob die Eingaben der Benutzer grundsätzlich valide sind. Auch dafür schreibst du Unit Tests.

### Aufgaben

1. Projekt mit der aktuellen Version klonen. Klone das GitLab-Repository in deine Entwicklungsumgebung VSCode (entweder über die Kommandozeile oder über die Extension in VSCode):

```bash
git clone https://gitlab.in.htwg-konstanz.de/lehre/rschimka/swen1/swen1-ws2425/00-swen1-ws2425.git
```

- checkout den branch `handout/bughandling`

- Erstelle als nächstes einen lokalen branch `meinnachname/main` , dabei ersetzt du `meinnachname` mit Deinem tatsächlichen Nachnamen!
- Erstelle ein Tag `rel-1.0.1` mit der Versionsnummer für diesen Branch
- Führe das Projekt mit Maven aus und prüfe die Ausgabe auf der Console: `mvn clean compile`
- Starte die Anwendung mit `mvn clean compile exec:java` auf der Console. In der Datei `pom.xml` ist festgelegt, welche Java-Klasse die entsprechende `main`-Methode zum Start der Anwendung enthält.

2. Neues Feature *Validierung der Eingaben* 

- Gemäss dem Feature-Branching (lokalen Branch meinnachname/feature-valdierung anlegen; Implementierung umsetzen; manuell testen; mergen auf meinnachme/main) realisiert du eine Validerung der Eingaben, so dass negative Zahlenwerte für Groesse und Gewicht eines Menschen abgefangen werden.
- Erzeuge ein neues Tag `rel-1.1.1`, das den neuen Feature-Stand widerspiegelt.



3. Bugfix implementieren und ausliefern

- Die Support-Abteilung meldet, dass im `rel-1.0.1` ein Fehler (Bug) bei der Berechnung des BMI enthalten ist. Untersuche die Implementierung in diesem Release (u.a. checkout dieses Release) und behebe das Problem (Feature-Branching für Bugfix).
- Überprüfe Deinen lokalen Fix manuell, indem du die Anwendung durch entsprechende Eingaben manuell testest. 
- Im Anschluss schreibst du Unit Tests dafür. 
- Mit `mvn test` führst du die Tests manuell aus.
- Wenn diese erfolgreich durchgelaufen sind, überführst du die Änderungen auf den neuen Branch `rel-1.0.2` und lieferst den Code an den Kunden aus. 
- Im Anschluss überführst du die Änderungen auf das remote git repository via `push` und überprüfst (über die Browseroberfläche von gitlab), ob der kontinuierliche Build in den Stages `build`und `test` erfolgreich in gitlab durchgelaufen ist.

4. Bugfix auf main überführen

- Der Bugfix betrifft auch die aktuelle Produktversion auf dem `main`- branch. Überführe die Bugfix-Änderungen auch auf den main-Branch. Beachte, dass der main-Branch die Valdidierungslogik enthält - der Bugfix-Branch nicht!
- Schliesslich stellst du die aktualisierte Version auf dem lokalen main auch in dem remote git (via `push`) zur Verfügung.

# Anhang CI/CD-Pipeline konfigurieren

Schaue dir  die `.gitlab-ci.yml` Datei im Root-Verzeichnis des Projekts an:

Ein Beispiel .gitlab-ci.yml:

```yaml
stages:
  - build
  - test

build:
  stage: build
  script:
    - mvn clean compile

test:
  stage: test
  script:
    - mvn test
```


