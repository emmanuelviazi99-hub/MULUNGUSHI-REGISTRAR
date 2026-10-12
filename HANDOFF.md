# Handoff: Mulungushi Registrar (MVVM restructure)

ICT361 group lab: Android (Java, XML Views) + Node.js/Express + MySQL. See ARCHITECTURE.md for the package map.

## What changed
- The flat `MulungushiRegistrar-connected` project was moved into MVVM packages (see ARCHITECTURE.md).
- `RequestRecord` is now a top-level class; `CAPACITY`, `PROGRAMMES`, `GROUPS`, `UNASSIGNED`, `DEMO_NUMBER_FALLBACK` moved from `StudentRepository` to `data/model/Rules`.
- Classes and members used across packages were made `public`; the manifest uses fully qualified activity names.
- Backend unchanged.

## NOT verified
No Android SDK or javac was available: the restructure was done by script and has not been compiled. First step: sync Gradle, build, fix any import/visibility errors, then click through every screen as student and lecturer. Run unit tests with `./gradlew testDebugUnitTest`.

## Run it
1. Backend: see `mulungushi-registrar-backend/README.md` (`npm install`, copy `.env.example` to `.env`, load `database/schema.sql` + `seed.sql`, `npm run seed:accounts`, `npm start`).
2. Set the server address in `data/remote/ApiConfig.java` (emulator `http://10.0.2.2:3000/api`; real phone: laptop IPv4).

## Still to do against the lab brief
- Room for local storage (replace in-memory `StudentRepository` data) plus a migration test.
- Wire `/api/students`, `/api/groups`, `/api/requests` into `StudentRepository`; Retrofit/OkHttp instead of HttpURLConnection; HTTPS.
- WorkManager sync queue (operation ID, student ID, account ID, type, payload, base version) and conflict handling.
- ViewModels (LiveData/SavedStateHandle) for Register, ForgotPassword, Student, Lecturer, Session; screens still call repositories directly, so the "ui -> viewmodel" rule is not yet enforced. Only LoginViewModel exists.
- Pagination, search cancellation, Sharesheet group summary, offline registration draft.
- Group-limit guarantee must be the server's MySQL transaction (Challenge 1); check `services/group.service.js`.
- Contribution log and AI/source log. Never commit `local.properties`, `.idea/`, `build/`, `node_modules/`, `.env`.
