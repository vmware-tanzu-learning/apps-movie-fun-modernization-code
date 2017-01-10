# Movie Fun!

## Tests

Smoke Tests require server running on port 8080 by default.

### Build JAR ignoring tests

```bash
$ ./gradlew clean build -xtest
```

### Run Smoke Tests against specific URL

```bash
$ MOVIE_FUN_URL=http://moviefun.example.com ./gradlew test
```

## Migrations

Create databases needed for local development with

```bash
mysql -uroot < databases/create_databases.sql
```

Run local migrations with

```bash
./gradlew flywayMigrate
```

Run migrations on the PCF environment which you're logged in to with

```bash
./gradlew cfMigrate
```
