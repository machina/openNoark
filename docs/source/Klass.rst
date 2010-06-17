Class
========

This controller provides basic crud functionality for Class objects.

WS methods
^^^^^^^^^^

The methods are described by the HTTP verb and url under /friak that is used to identify it.

POST /ws/klass
~~~~~~~~~~~~~~~~

Creates a new Class and returns it.

Example input:

<klass>
  <title>Test Klass 1</title>
  <parentClassificationSystem id="3" />
  <classID>1</classID>
</klass>

Example output:

<klass id="22">
  <childFile/>
  <preservationAndDisposal/>
  <parentClassificationSystem id="3"/>
  <parentClass/>
  <keyword/>
  <classID>
    1
  </classID>
  <finalisedBy/>
  <childClass/>
  <childRecord/>
  <title>
    Test Klass 1
  </title>
  <screening/>
  <createdBy>
    admin
  </createdBy>
  <finalisedDate/>
  <description/>
  <systemID>
    95d4d910-0f43-49e0-bf4a-05873efc7cff
  </systemID>
  <createdDate>
    2010-06-16 13:19:48.806 CEST
  </createdDate>
</klass>

GET /ws/klass
~~~~~~~~~~~~~~

Returns a list of all Class objects.

Example output:

<list>
	<klass id="22">
  	<childFile/>
	  <preservationAndDisposal/>
  	<parentClassificationSystem id="3"/>
	  <parentClass/>
  	<keyword/>
	  <classID>
  	  1
	  </classID>
  	<finalisedBy/>
	  <childClass/>
  	<childRecord/>
	  <title>
  	  Test Klass 1
	  </title>
  	<screening/>
	  <createdBy>
  	  admin
	  </createdBy>
  	<finalisedDate/>
	  <description/>
  	<systemID>
    	95d4d910-0f43-49e0-bf4a-05873efc7cff
	  </systemID>
  	<createdDate>
    	2010-06-16 13:19:48.806 CEST
	  </createdDate>
	</klass>
</list>
GET /ws/klass/<id>
~~~~~~~~~~~~~~~~~~~

Returns the specified object.

Example:

Doing a GET on /ws/klass/32 might produce the output:

<klass id="22">
  <childFile/>
  <preservationAndDisposal/>
  <parentClassificationSystem id="3"/>
  <parentClass/>
  <keyword/>
  <classID>
    1
  </classID>
  <finalisedBy/>
  <childClass/>
  <childRecord/>
  <title>
    Test Klass 1
  </title>
  <screening/>
  <createdBy>
    admin
  </createdBy>
  <finalisedDate/>
  <description/>
  <systemID>
    95d4d910-0f43-49e0-bf4a-05873efc7cff
  </systemID>
  <createdDate>
    2010-06-16 13:19:48.806 CEST
  </createdDate>
</klass>

PUT /ws/klass
~~~~~~~~~~~~~~~~

Updates and returns a klass.

Example input:

<klass id="22">
  <childFile/>
  <preservationAndDisposal/>
  <parentClassificationSystem id="3"/>
  <parentClass/>
  <keyword/>
  <classID>
    1
  </classID>
  <finalisedBy/>
  <childClass/>
  <childRecord/>
  <title>
    Updated Klass 1
  </title>
  <screening/>
  <createdBy>
    admin
  </createdBy>
  <finalisedDate/>
  <description>
		With updated description
	</decription>
  <systemID>
    95d4d910-0f43-49e0-bf4a-05873efc7cff
  </systemID>
  <createdDate>
    2010-06-16 13:19:48.806 CEST
  </createdDate>
</klass>

Output should match input.

DELETE /ws/klass/<id>
~~~~~~~~~~~~~~~~~~~~~~

Deletes a Class.

Example:

DELETE /ws/klass/22 

should delete the Class with id 22.
