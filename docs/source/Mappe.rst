File
========

This controller provides basic crud functionality for File objects.

WS methods
^^^^^^^^^^

The methods are described by the HTTP verb and url under /friak that is used to identify it.

POST /ws/mappe
~~~~~~~~~~~~~~~~

Creates a new File and returns it.

Example input:

<basicFile>
  <fileType>BasicFile</fileType>
  <title>Test File 1</title>
  <recordSection id="32" />
</basicFile>

Example output:

<basicFile id="16">
  <recordSection id="15"/>
  <childFile/>
  <fileType>
    BasicFile
  </fileType>
  <parentClass/>
  <keyword/>
  <documentMedium/>
  <storageLocation/>
  <officialTitle/>
  <finalisedBy/>
  <bevaringOgKassasjon/>
  <childRecord/>
  <title>
    Test File 1
  </title>
  <fileID>
    1
  </fileID>
  <createdBy>
     admin
  </createdBy>
  <finalisedDate/>
  <merknad/>
  <description/>
  <systemID>
		781d16d7-1635-462d-b122-6a9857409185
  </systemID>
  <parentFile/>
  <createdDate>
    2010-06-16 13:19:43.357 CEST
  </createdDate>
</basicFile>


GET /ws/mappe
~~~~~~~~~~~~~~

Returns a list of all File objects.

Example output:

<list>
	<basicFile id="16">
	  <recordSection id="15"/>
  	<childFile/>
	  <fileType>
  	  BasicFile
	  </fileType>
  	<parentClass/>
	  <keyword/>
  	<documentMedium/>
	  <storageLocation/>
  	<officialTitle/>
	  <finalisedBy/>
  	<bevaringOgKassasjon/>
	  <childRecord/>
  	<title>
    	Test File 1
	  </title>
  	<fileID>
    	1
	  </fileID>
  	<createdBy>
    	 admin
	  </createdBy>
  	<finalisedDate/>
	  <merknad/>
  	<description/>
	  <systemID>
			781d16d7-1635-462d-b122-6a9857409185
  	</systemID>
	  <parentFile/>
  	<createdDate>
    	2010-06-16 13:19:43.357 CEST
	  </createdDate>
	</basicFile>
</list>
GET /ws/mappe/<id>
~~~~~~~~~~~~~~~~~~~

Returns the specified object.

Example:

Doing a GET on /ws/mappe/16 might produce the output:

<basicFile id="16">
  <recordSection id="15"/>
  <childFile/>
  <fileType>
    BasicFile
  </fileType>
  <parentClass/>
  <keyword/>
  <documentMedium/>
  <storageLocation/>
  <officialTitle/>
  <finalisedBy/>
  <bevaringOgKassasjon/>
  <childRecord/>
  <title>
    Test File 1
  </title>
  <fileID>
    1
  </fileID>
  <createdBy>
     admin
  </createdBy>
  <finalisedDate/>
  <merknad/>
  <description/>
  <systemID>
		781d16d7-1635-462d-b122-6a9857409185
  </systemID>
  <parentFile/>
  <createdDate>
    2010-06-16 13:19:43.357 CEST
  </createdDate>
</basicFile>


PUT /ws/mappe
~~~~~~~~~~~~~~~~

Updates and returns a mappe.

Example input:

<basicFile id="16">
  <recordSection id="15"/>
  <childFile/>
  <fileType>
    BasicFile
  </fileType>
  <parentClass/>
  <keyword/>
  <documentMedium/>
  <storageLocation/>
  <officialTitle/>
  <finalisedBy/>
  <bevaringOgKassasjon/>
  <childRecord/>
  <title>
    Updated File 1
  </title>
  <fileID>
    1
  </fileID>
  <createdBy>
     admin
  </createdBy>
  <finalisedDate/>
  <merknad/>
  <description/>
  <systemID>
		781d16d7-1635-462d-b122-6a9857409185
  </systemID>
  <parentFile/>
  <createdDate>
    2010-06-16 13:19:43.357 CEST
  </createdDate>
</basicFile>


Output should match input.

DELETE /ws/mappe/<id>
~~~~~~~~~~~~~~~~~~~~~~

Deletes a File.

Example:

DELETE /ws/mappe/16

should delete the File with id 16.
