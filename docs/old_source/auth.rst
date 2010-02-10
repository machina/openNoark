Auth
========

Auth controlleren lar brukere logge seg inn og ut.

WS metoder
^^^^^^^^^^^

/auth/signIn?username=[username]&password=[password]
~~~~~~~~~~~~~~

	Logger inn som brukeren med brukernavn [username] og passord [password]. Retunerer html-versjon av innloggingsiden ved feil og
  html versjon av friark sin default hovedside ved suksess.
