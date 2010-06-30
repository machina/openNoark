ClassificationSystem
========

This controller provides basic crud functionality for ClassificationSystem objects.

WS methods
^^^^^^^^^^

The methods are described by the HTTP verb and url under /friak that is used to identify it.

POST /ws/classificationSystem
~~~~~~~~~~~~~~~~

Creates a new ClassificationSystem and returns it.

Example input:
<classificationSystem>
  <title>Test ClassificationSystem 1</title>
</classificationSystem>

Example output:

<classificationSystem id="3">
   <finalisedBy/>
   <child/>
   <title>
     Test ClassificationSystem 1
   </title>
   <createdBy>
     admin
   </createdBy>
   <finalisedDate/>
   <description/>
   <classificationType/>
   <systemID>
     b0754b97-ce21-42f6-aad7-10d884374463
   </systemID>
   <createdDate>
     2010-06-16 13:19:36.729 CEST
   </createdDate>
</classificationSystem>

GET /ws/classificationSystem
~~~~~~~~~~~~~~

Returns a list of all ClassificationSystem objects.

Example output:

<list>
	<classificationSystem id="3">
   <finalisedBy/>
   <child/>
   <title>
     Test ClassificationSystem 1
   </title>
   <createdBy>
     admin
   </createdBy>
   <finalisedDate/>
   <description/>
   <classificationType/>
   <systemID>
     b0754b97-ce21-42f6-aad7-10d884374463
   </systemID>
   <createdDate>
     2010-06-16 13:19:36.729 CEST
   </createdDate>
	</classificationSystem>
</list>
GET /ws/classificationSystem/<id>
~~~~~~~~~~~~~~~~~~~

Returns the specified object.

Example:

Doing a GET on /ws/classificationSystem/3 migth produce the output:

<classificationSystem id="3">
   <finalisedBy/>
   <child/>
   <title>
     Test ClassificationSystem 1
   </title>
   <createdBy>
     admin
   </createdBy>
   <finalisedDate/>
   <description/>
   <classificationType/>
   <systemID>
     b0754b97-ce21-42f6-aad7-10d884374463
   </systemID>
   <createdDate>
     2010-06-16 13:19:36.729 CEST
   </createdDate>
</classificationSystem>



PUT /ws/classificationSystem
~~~~~~~~~~~~~~~~

Updates and returns a classificationSystem.

Example input:

<classificationSystem id="3">
   <finalisedBy/>
   <child/>
   <title>
     Updated ClassificationSystem 1
   </title>
   <createdBy>
     admin
   </createdBy>
   <finalisedDate/>
   <description/>
   <classificationType/>
   <systemID>
     b0754b97-ce21-42f6-aad7-10d884374463
   </systemID>
   <createdDate>
     2010-06-16 13:19:36.729 CEST
   </createdDate>
</classificationSystem>


Output should match input.

DELETE /ws/classificationSystem/<id>
~~~~~~~~~~~~~~~~~~~~~~

Deletes a ClassificationSystem.

Example:

DELETE /ws/classificationSystem/3 

should delete the ClassificationSystem with id 3.
