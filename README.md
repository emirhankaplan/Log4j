# Log4j 2 — Scheduled Logging with a Rolling File Appender

A small Java example that uses **Apache Log4j 2** to write timestamps at different log levels on different schedules into a size-based rolling log file.

## ⚙️ What it does

`Log4jj/src/main/java/org/example/myTimerLoggings.java` schedules three `java.util.Timer` tasks:

| Level | Interval | First run |
| --- | --- | --- |
| `DEBUG` | every second | immediately |
| `INFO` | every minute | at the start of the next minute |
| `ERROR` | every hour | at the start of the next hour |

Configuration lives in `Log4jj/src/main/resources/log4j2.xml`:

- Output file: `C:/temp/logs/Timer-<dd-MM-yyyy>.log`
- Rolls over when the file reaches **1 MB**
- Pattern: `HH:mm:ss.SSS [thread] LEVEL logger - message`

A sample log produced by the app is included under `Log4jj/C:/temp/logs/`.

## 🧰 Tech stack

Java · Maven · Log4j 2.17.1 (`log4j-api`, `log4j-core`)

## 🚀 Running it

```bash
cd Log4jj
mvn compile exec:java -Dexec.mainClass=org.example.myTimerLoggings
```

> ℹ️ The log directory is a Windows path. On macOS / Linux change the `basePath` property in `log4j2.xml` (for example to `logs`).
