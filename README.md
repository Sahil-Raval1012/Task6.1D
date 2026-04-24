# Task6.1D — LLM-Enhanced Learning Assistant App

A simple Android app built with **Kotlin + XML** for SIT708 Task 6.1D.

## Features

The app implements every screen from the wireframes:

1. **Login** (`MainActivity`) – username + password, link to sign up.
2. **Sign Up** (`SignUpActivity`) – username, email + confirm, password + confirm, phone, with validation.
3. **Interests** (`InterestsActivity`) – pick up to 10 topics from a chip list.
4. **Home** (`HomeActivity`) – greets the user, shows generated task cards.
5. **Task** (`TaskActivity`) – multiple-choice quiz with **Get a hint** (LLM call) on every question.
6. **Results** (`ResultsActivity`) – per-question correctness with **Why is this correct?** (LLM call).

### LLM-powered learning utilities (2+ as required)

- **Generate hint for a question** – on the Task screen.
- **Explain why an answer is correct/incorrect** – on the Results screen.

Both show **prompt + response in the UI** and handle **loading / failure** states. They call Google's
free Gemini API via plain `HttpURLConnection` (no extra SDK needed). If you don't paste an API
key, the app falls back to deterministic offline responses so the demo still works.

### Polish

- Smooth fade + slide-in entrance animations on cards and questions.
- Activity slide transitions on navigation.
- Consistent back navigation (every screen has a Back affordance, no dead ends).
- Readable font sizes (≥13sp body, ≥16sp headings).
- All buttons have meaningful labels and `contentDescription` for accessibility.

## Project structure

```
Task6.1D/
├── build.gradle.kts                  Project Gradle config
├── settings.gradle.kts
├── gradle.properties
├── gradle/wrapper/
└── app/
    ├── build.gradle.kts              Module config (compileSdk 34, minSdk 24)
    └── src/main/
        ├── AndroidManifest.xml
        ├── java/com/example/task61d/
        │   ├── MainActivity.kt        Login
        │   ├── SignUpActivity.kt
        │   ├── InterestsActivity.kt
        │   ├── HomeActivity.kt
        │   ├── TaskActivity.kt
        │   ├── ResultsActivity.kt
        │   ├── adapters/TaskAdapter.kt
        │   ├── data/                  Models, dummy content, in-memory session
        │   └── llm/LlmClient.kt       Gemini REST + offline fallback
        └── res/
            ├── layout/                XML layouts for each screen + list items
            ├── drawable/              Backgrounds, buttons, icons (vector)
            ├── values/                colors.xml, strings.xml, themes.xml, styles.xml
            └── mipmap-anydpi-v26/     Adaptive launcher icons
```

## Open & Run in Android Studio

1. Open Android Studio (Hedgehog or newer recommended).
2. **File → Open…** and select the `Task6.1D` folder.
3. When prompted, let Android Studio download Gradle 8.7 and the Android SDK 34 components.
4. Choose a device or emulator (API 24+) and press **Run** ▶.

## Enable real LLM responses (optional)

1. Get a free key at <https://aistudio.google.com/app/apikey>.
2. Open `app/src/main/java/com/example/task61d/llm/LlmClient.kt`.
3. Paste the key into the `API_KEY` constant. Run again — the app now calls Gemini live.

If the key is blank or the network fails, the app uses a built-in fallback so every demo still runs.

## Requirements checklist

| Requirement                                    | Status |
| ----------------------------------------------| ------ |
| All wireframe screens included                 | ✅      |
| ≥ 2 LLM-powered learning utilities             | ✅ Hint + Explain answer |
| Prompt + response shown in the UI              | ✅      |
| Loading & failure states handled               | ✅      |
| Readable text, meaningful labels, no dead ends | ✅      |
| Smooth animations                              | ✅ Fade/slide on lists & navigation |
| Dummy data populates the app                   | ✅ `DummyData.kt` |
