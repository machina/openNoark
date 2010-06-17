Search
========

This controller provides basic search functionality for meatadat searches

WS methods
^^^^^^^^^^

The methods are described by the HTTP verb and url under /friak that is used to identify it.

GET /ws/search/<query>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Returns a list of all object that are found by searching in all the metadata using the entered query.

Example: 
GET /friark/ws/search/test

GET /ws/search/<className>/<query>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Returns a list of all object of the specified class that are found by searching in all the metadata using the entered query.

Example: 
GET /friark/ws/search/Fonds/test
