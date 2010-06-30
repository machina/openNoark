Arkiv
=====

This controller provides basic crud fintionality for Fonds objects.

WS methods
^^^^^^^^^^

The methods are described by the HTTP verb and url under /friak that is used to identify it.

POST /ws/arkiv
~~~~~~~~~~~
Creates a new Fonds and returns it. 

Example XML input:

<fonds>
  <title>Test Fonds 1</title>
</fonds>

Example XML output:

<fonds id="18">
	<fondsCreator/>
  <referenceChildSeries/>
  <parent/>
  <documentMedium/>
  <storageLocation/>
  <finalisedBy/>
  <fondsStatus>
     Opprettet
  </fondsStatus>
  <title>
	  Test Fonds 1
  </title>
  <createdBy>
     admin
  </createdBy>
  <finalisedDate/>
  <description/>
  <systemID>
     9ab188a8-1f75-4d02-aea4-e5d5f4298bd6
  </systemID>
  <subFonds/>
  <createdDate>
   2010-06-16 13:19:45.404 CEST
  </createdDate>
</fonds>


GET /ws/arkiv
~~~~~~~~~~~

Calling the archive controller with get and providing no id returns a list of objects.

Example XML output:

<list>
  <fonds id="18">
    <fondsCreator/>
    <referenceChildSeries/>
    <parent/>
    <documentMedium/>
    <storageLocation/>
    <finalisedBy/>
    <fondsStatus>
       Opprettet
    </fondsStatus>
    <title>
      Test Fonds 1
    </title>
    <createdBy>
      admin
    </createdBy>
    <finalisedDate/>
    <description/>
    <systemID>
      9ab188a8-1f75-4d02-aea4-e5d5f4298bd6
    </systemID>
    <subFonds/>
    <createdDate>
      2010-06-16 13:19:45.404 CEST
    </createdDate>
  </fonds>
</list>

GET /ws/arkiv/<id>
~~~~~~~~~~~

Calling the archive controller with get and providing a id returns a that objects.

Example:

Doing a GET on /ws/arkiv/18 migth produce the output:

<fonds id="18">
  <fondsCreator/>
  <referenceChildSeries/>
  <parent/>
  <documentMedium/>
  <storageLocation/>
  <finalisedBy/>
  <fondsStatus>
     Opprettet
  </fondsStatus>
  <title>
    Test Fonds 1
  </title>
  <createdBy>
     admin
  </createdBy>
  <finalisedDate/>
  <description/>
  <systemID>
     9ab188a8-1f75-4d02-aea4-e5d5f4298bd6
  </systemID>
  <subFonds/>
  <createdDate>
   2010-06-16 13:19:45.404 CEST
  </createdDate>
</fonds>

PUT /ws/arkiv
~~~~~~~~~~~~~
Updates a archive and returns the updated archive.

Example input:

<fonds id="18">
  <fondsCreator/>
  <referenceChildSeries/>
  <parent/>
  <documentMedium/>
  <storageLocation/>
  <finalisedBy/>
  <fondsStatus>
     Opprettet
  </fondsStatus>
  <title>
    Updated title
  </title>
  <createdBy>
     admin
  </createdBy>
  <finalisedDate/>
  <description/>
  <systemID>
     9ab188a8-1f75-4d02-aea4-e5d5f4298bd6
  </systemID>
  <subFonds/>
  <createdDate>
   2010-06-16 13:19:45.404 CEST
  </createdDate>
</fonds>

Output should match input.

DELETE /ws/arkiv/<id>
~~~~~~~~~~~~~~~~~~~~~~

Deletes a Fonds.

Example:

DELETE /ws/arkiv/32 

should delete the Fonds with id 32.
