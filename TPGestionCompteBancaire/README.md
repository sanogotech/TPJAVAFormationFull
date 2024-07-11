
### Structure du Projet Maven

Assurez-vous d'avoir la structure de répertoires suivante pour votre projet Maven :

```
GuichetBancaire/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   ├── GuichetBancaire.java   // Votre fichier source principal
│                   └── CompteBancaire.java    // Classe CompteBancaire
└── pom.xml   // Fichier de configuration Maven
```

### `pom.xml` - Configuration Maven

Voici le contenu du fichier `pom.xml` avec le plugin `maven-assembly-plugin` configuré pour créer un JAR exécutable :

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   <groupId>com.example</groupId>
   <artifactId>GuichetBancaire</artifactId>
   <version>1.0-SNAPSHOT</version>
   <properties>
       <maven.compiler.source>1.8</maven.compiler.source>
       <maven.compiler.target>1.8</maven.compiler.target>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
   </properties>
   <dependencies>
       <!-- Aucune dépendance externe n'est requise pour ce projet -->
   </dependencies>
   <build>
       <plugins>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-compiler-plugin</artifactId>
               <version>3.8.1</version>
               <configuration>
                   <source>${maven.compiler.source}</source>
                   <target>${maven.compiler.target}</target>
                   <encoding>${project.build.sourceEncoding}</encoding>
               </configuration>
           </plugin>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-assembly-plugin</artifactId>
               <version>3.3.0</version>
               <configuration>
                   <archive>
                       <manifest>
                           <mainClass>com.example.GuichetBancaire</mainClass>
                       </manifest>
                   </archive>
                   <descriptorRefs>
                       <descriptorRef>jar-with-dependencies</descriptorRef>
                   </descriptorRefs>
               </configuration>
               <executions>
                   <execution>
                       <id>make-assembly</id>
                       <phase>package</phase>
                       <goals>
                           <goal>single</goal>
                       </goals>
                   </execution>
               </executions>
           </plugin>
       </plugins>
   </build>
</project>
```

### Explication du `pom.xml` :

- **`maven-compiler-plugin` :** Configure le plugin pour compiler le code source avec la version Java spécifiée.
- **`maven-assembly-plugin` :** Permet de créer un JAR exécutable avec toutes les dépendances incluses (`jar-with-dependencies`).
- **`mainClass` :** Spécifie la classe principale à exécuter lorsque le JAR est lancé.

### Compilation et Création du JAR

Pour compiler et créer le JAR exécutable :

1. **Compilation :**
   ```
   mvn compile
   ```

2. **Création du JAR :**
   ```
   mvn package
   ```

   Cela va créer un fichier JAR dans le répertoire `target/` avec le suffixe `-jar-with-dependencies.jar`.

### Exécution du JAR

Une fois le JAR créé, vous pouvez l'exécuter avec la commande suivante :

```
java -jar target/GuichetBancaire-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Assurez-vous d'adapter le chemin du JAR en fonction de ce que Maven a généré dans votre répertoire `target/`.

En suivant ces étapes, vous pouvez compiler, créer et exécuter votre programme Java sous forme de JAR exécutable avec toutes les dépendances incluses, facilitant ainsi le déploiement et l'exécution sur différentes plates-formes.