# Architecture (MVVM package map)

Package root: `zm.ac.mulungushi.registrar`

```
ui -> viewmodel -> repository -> local | remote -> backend (Node.js/Express -> MySQL)
```

| Layer      | Package                                   | Contents |
|------------|-------------------------------------------|----------|
| View       | `ui/auth`                                 | Splash, Login, Register, ForgotPassword, ResendTimer, NrcTextWatcher |
|            | `ui/student`                              | StudentHome, MyGroup, GroupChange, EditDetails |
|            | `ui/lecturer`                             | LecturerDashboard, LecturerRoster, Requests, EditStudentSheet, StudentAdapter, RosterFormat |
|            | `ui/sync`                                 | SyncActivity |
|            | `ui/common`                               | BottomNav, ConnectivityBanner, SignOutSheet, Feedback, Notifier, CrashLog |
| ViewModel  | `viewmodel`                               | LoginViewModel |
| Repository | `data/repository`                         | StudentRepository, Auth, AuthService |
| Local      | `data/local`                              | Session (SharedPreferences) |
| Remote     | `data/remote`                             | ApiConfig, ApiClient, ApiAuthService |
| Model      | `data/model`                              | Student, RequestRecord, Rules |
| Util       | `util`                                    | LoginValidator, StudentValidator, ContactValidator (plain Java) |
| App        | `.`                                       | RegistrarApp |

Backend: `mulungushi-registrar-backend/` (routes -> controllers -> services -> MySQL).
