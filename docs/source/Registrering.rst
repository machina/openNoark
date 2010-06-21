Record
========

This controller provides basic crud functionality for Record objects.

WS methods
^^^^^^^^^^

The methods are described by the HTTP verb and url under /friak that is used to identify it.

POST /ws/registrering
~~~~~~~~~~~~~~~~

Creates a new Record and returns it.

Example input:

<simplifiedRecord>
  <recordType>Forenkletregistrering</recordType>
  <parentFile id="16" />
  <archivedBy>Test SimplifiedRecord 1</archivedBy>
  <archivedDate>2010-06-15 16:01:18.281 CEST</archivedDate>
</simplifiedRecord>

Example output:

<simplifiedRecord id="40">
  <recordSection/>
   <preservationAndDisposal/>
   <parentClass/>
   <documentObject/>
   <archivedBy>
     Test SimplifiedRecord 1
   </archivedBy>
   <document/>
   <createdBy>
     admin
   </createdBy>
   <systemID>
     e22d2f7d-e1e7-4943-8b47-ef3f4b7ea678
   </systemID>
   <parentFile id="16"/>
   <recordType>
     Forenkletregistrering
   </recordType>
   <archivedDate>
     2010-06-15 16:01:18.281 CEST
   </archivedDate>
   <createdDate>
     2010-06-16 13:19:54.939 CEST
   </createdDate>
</simplifiedRecord>

GET /ws/registrering
~~~~~~~~~~~~~~

Returns a list of all Record objects.

Example output:

<list>
<simplifiedRecord id="40">
  <recordSection/>
   <preservationAndDisposal/>
   <parentClass/>
   <documentObject/>
   <archivedBy>
     Test SimplifiedRecord 1
   </archivedBy>
   <document/>
   <createdBy>
     admin
   </createdBy>
   <systemID>
     e22d2f7d-e1e7-4943-8b47-ef3f4b7ea678
   </systemID>
   <parentFile id="16"/>
   <recordType>
     Forenkletregistrering
   </recordType>
   <archivedDate>
     2010-06-15 16:01:18.281 CEST
   </archivedDate>
   <createdDate>
     2010-06-16 13:19:54.939 CEST
   </createdDate>
</simplifiedRecord>

</list>
GET /ws/registrering/<id>
~~~~~~~~~~~~~~~~~~~

Returns the specified object.

Example:

Doing a GET on /ws/registrering/40 might produce the output:

<simplifiedRecord id="40">
  <recordSection/>
   <preservationAndDisposal/>
   <parentClass/>
   <documentObject/>
   <archivedBy>
     Test SimplifiedRecord 1
   </archivedBy>
   <document/>
   <createdBy>
     admin
   </createdBy>
   <systemID>
     e22d2f7d-e1e7-4943-8b47-ef3f4b7ea678
   </systemID>
   <parentFile id="16"/>
   <recordType>
     Forenkletregistrering
   </recordType>
   <archivedDate>
     2010-06-15 16:01:18.281 CEST
   </archivedDate>
   <createdDate>
     2010-06-16 13:19:54.939 CEST
   </createdDate>
</simplifiedRecord>


PUT /ws/registrering
~~~~~~~~~~~~~~~~

Updates and returns a registrering.

Example input:
<simplifiedRecord id="40">
  <recordSection/>
   <preservationAndDisposal/>
   <parentClass/>
   <documentObject/>
   <archivedBy>
     SimplifiedRecord with update
   </archivedBy>
   <document/>
   <createdBy>
     admin
   </createdBy>
   <systemID>
     e22d2f7d-e1e7-4943-8b47-ef3f4b7ea678
   </systemID>
   <parentFile id="16"/>
   <recordType>
     Forenkletregistrering
   </recordType>
   <archivedDate>
     2010-06-15 16:01:18.281 CEST
   </archivedDate>
   <createdDate>
     2010-06-16 13:19:54.939 CEST
   </createdDate>
</simplifiedRecord>

Output should match input.

DELETE /ws/registrering/<id>
~~~~~~~~~~~~~~~~~~~~~~

Deletes a Record.

Example:

DELETE /ws/registrering/40

should delete the Record with id 40.
