# Milestone 0 — Notes, Decisions, Followups
---

## Status

✅ **M0 closed.** Verdict: APPROVED WITH FOLLOWUPS.

---

## What Got Built

- `pom.xml` with `groupId=com.lazarobeas`, `artifactId=casino-java`, `version=0.1.0-SNAPSHOT`, `<maven.compiler.release>21</maven.compiler.release>`, UTF-8 encoding, JUnit Jupiter `6.0.3` and AssertJ `3.27.7` as test-scoped dependencies, `maven-surefire-plugin` 3.5.5 and `exec-maven-plugin` 3.6.3 in `<build><plugins>`.
- `.gitignore` covering `target/`, `.idea/`, `*.iml`, `*.iws`, `*.ipr`, `.DS_Store`, `*.log`, `out/`. (`.vscode/` not yet added — minor followup.)
- `src/main/java/com/lazarobeas/casino/CasinoApplication.java` — `main` method prints `"Starting casino..."`.
- `src/test/java/com/lazarobeas/casino/SanityTest.java` — package-private test class, one test asserting `1+1 == 2` via AssertJ `assertThat`.
- `README.md` with title, version section, M0 status note, Build & Run, Project Structure tree.
- Build verified: `mvn clean verify` exits 0, Surefire reports `Tests run: 1, Failures: 0, Errors: 0`.
- Repo: `https://github.com/lazarobeas/casino-java.git`, pushed to `main`.

## Local Setup

- Working directory: `/Users/lazarobeas/Desktop/casino-java`
- macOS 26.2 on Apple Silicon (aarch64)
- Java: Temurin 21.0.11 (LTS) via SDKMAN
- Maven: 3.9.15 via SDKMAN
- IDE: IntelliJ IDEA Ultimate

## Decisions Made During M0

1. **Java 21 over Java 25.** Student had Java 25 installed; we installed 21 LTS via SDKMAN to match the version that BNY's stack and Spring Boot 3.x most commonly target.
2. **SDKMAN for JDK and Maven management.** Single tool for both, clean PATH, easy version pinning.
3. **`com.lazarobeas` as Maven groupId.** Reverse-DNS based on GitHub handle since the student doesn't own a domain that's a better fit.
4. **`<maven.compiler.release>21</maven.compiler.release>`** instead of `<source>`/`<target>`. Modern, enforces no accidental use of post-21 APIs.
5. **JUnit Jupiter aggregator artifact** (not separate API + engine artifacts).
6. **Pacing reframed: 4–8 weeks instead of 10 working days.** Student has 2–5 hours/day, ~3 average. Mastery over speed.
7. **Process-tone calibration.** Tutor will be direct and substantive on technical feedback but will not perform sternness or psychoanalyze the student. Engagement is collegial, peer-to-peer on process questions, senior-to-junior on technical depth.
8. **ADR policy revised.** ADRs are written when there is a real decision with a live alternative. ADRs at M0 (Maven, package layout) were dropped because both choices were prescribed and had no live alternatives. ADRs are required at M7 (Bet hierarchy: abstract class vs interface) and M8 (JDBC migration runner + prepared-statement rationale). The tutor will flag any other point where an ADR is warranted; student may push back if the tutor reflexively requests one for a non-decision.
9. **Three commits at M0 root, not the suggested 4–6 atomic commits.** The student declined to interactively rebase to split them, citing a broken vim setup. Acceptable. Going forward, commits must be atomic from the start; rewriting history is not the recovery path of choice.
10. **Vim editor issue deferred.** Student's git editor is unconfigured/broken. To be fixed before M1 close so future rebases and commit message editing work. `git config --global core.editor "code --wait"` (VS Code) or `idea --wait` (IntelliJ) or `nano` are all acceptable resolutions.

## Followups Carried Into M1

These do not block M1 but should be cleaned up by the time we close M2 at the latest:

1. **README cleanup.** The current README has a journal-style "May 4, 2026: I have created..." paragraph that belongs in commit messages or a separate `JOURNAL.md`. README is documentation for users of the project, not a diary. Strip the reflective prose. Add a `**Status:** Milestone N` line that gets updated each milestone.
2. **Remove ADR references from README's project structure tree.** The tree currently lists `docs/adr/0001-build-tool.md` and `docs/adr/0002-package-layout.md`, which were dropped. Remove those lines. Either delete `docs/` entirely until M7 or leave the empty directory; either is fine.
3. **Add `.vscode/` to `.gitignore`.** Was in the original spec, missed in the fix.
4. **Configure git editor.** See decision #10 above.
5. **Atomic commits going forward.** From M1 onward, every commit follows `<type>: <imperative phrase>` and represents one logical change. M0's three-commit history is grandfathered in but not the standard.
6. **IntelliJ source roots.** Student noticed coffee-cup icons instead of blue/green class icons, indicating IntelliJ may not have imported the project as Maven. Resolution path: delete `.idea/`, close IntelliJ, reopen via `File → Open` pointed at `pom.xml` (not the directory). If that doesn't work, paste the Project Structure → Modules → Sources output for diagnosis.

## Lessons Recorded

- **`<dependencyManagement>` vs `<dependencies>` is not interchangeable.** The first is version policy for child modules; the second adds artifacts to the classpath. Putting deps in the wrong block produces a silent failure: Maven records the version policy, the JARs never reach the classpath, and tests fail to compile because the imports can't resolve.
- **Plugins go in `<build><plugins>`, not in any dependency block.** A plugin is something Maven runs at build time. A dependency is a library your code links against. Different categories.
- **Always pin stable releases for dependencies.** Pre-release suffixes (`-RC`, `-M`, `-alpha`, `-beta`, `-SNAPSHOT`) are not for production or for stable learning projects. Maven Central's default sort can show pre-releases first; verify the version is stable before pasting it into a `pom.xml`.
- **A sanity test must assert something that could, in principle, fail.** `assertThat(x).isEqualTo(x)` proves nothing about the test framework. `assertThat(1+1).isEqualTo(2)` is the canonical form: distinct expression on the left, distinct value on the right, an actual comparison.
- **Run the Definition of Done checklist yourself before submitting.** Do not submit a milestone whose own DoD is failing.
- **Project review and process review are separate axes.** Code-review feedback is for code; engagement-style feedback should be addressed when raised, but separately, and without contaminating the technical review thread.

## State for the Next Chat

- M0 is closed.
- Next target: **Milestone 1 — The Card Domain.**
- Concepts on deck: enums with fields, `Comparable<T>`, `equals`/`hashCode`, immutability, package-private vs. public visibility.
- Student is ready for the M1 spec.
