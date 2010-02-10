Basismappe
==========

Kontroller for funksjoner på basismapper.

WS metoder
^^^^^^^^^^^

/basismappe/list
~~~~~~~~~~~~~~

  Returnerer alle basismapper i systemet som HTML, XML eller JSON basert på accept header eller suffix (for eksempel /basismappe/list.xml).

/basismappe/list/[id]
~~~~~~~~~~~~~~~~~~~~~

  Returnerer en representasjon av basismappen med gitt id i HTML eller XML format basert på accept header eller suffix.

/basismappe/save
~~~~~~~~~~~~~~~~

  Kallet med en HTTP POST og lagrer en ny mappe basert på innkommende vedier. Returnerer en representasjon av den lagrede 
  mappen.
	
