Series
========

This controller provides basic crud functionality for Series objects.

WS methods
^^^^^^^^^^

The methods are described by the HTTP verb and url under /friak that is used to identify it.

POST /ws/series
~~~~~~~~~~~~~~~~

Creates a new Series and returns it.

Example input:

<series>
  <title>Test Series 1</title>
  <documentMedium>Papyrus</documentMedium>
  <parent>18</parent>   
</series>

Example output:

<series id="32">
  <preservationAndDisposal/>
  <successor/>
   <recordsPeriodStartDate/>
   <precursor/>
   <recordSectionStatus>
     Opprettet
   </recordSectionStatus>
   <parent id="18"/>
   <documentMedium>
     Papyrus
   </documentMedium>
   <storageLocation/>
   <finalisedBy/>
   <periodStatus/>
   <record/>
   <title>
     Test Series 1
   </title>
   <createdBy>
     admin
   </createdBy>
   <finalisedDate/>
   <description/>
   <file/>
   <systemID>
     c23cfa35-0382-4010-9d96-6208cf5cd1a9
   </systemID>
   <recordsPeriodEndDate/>
   <classificationSystem/>
   <createdDate>
     2010-06-16 13:19:52.207 CEST
	</createdDate>
</series>

GET /ws/series
~~~~~~~~~~~~~~

Returns a list of all Series objects.

Example output:

<list>
	<series id="32">
		<preservationAndDisposal/>
  	<successor/>
	  <recordsPeriodStartDate/>
  	<precursor/>
    <recordSectionStatus>
     Opprettet
    </recordSectionStatus>
    <parent id="18"/>
    <documentMedium>
     Papyrus
    </documentMedium>
    <storageLocation/>
    <finalisedBy/>
    <periodStatus/>
    <record/>
    <title>
     Test Series 1
    </title>
    <createdBy>
     admin
    </createdBy>
    <finalisedDate/>
    <description/>
    <file/>
    <systemID>
     c23cfa35-0382-4010-9d96-6208cf5cd1a9
    </systemID>
    <recordsPeriodEndDate/>
    <classificationSystem/>
    <createdDate>
     2010-06-16 13:19:52.207 CEST
   	</createdDate>
	</series>
</list>
GET /ws/series/<id>
~~~~~~~~~~~~~~~~~~~

Returns the specified object.

Example:

Doing a GET on /ws/series/32 migth produce the output:

<series id="32">
  <preservationAndDisposal/>
  <successor/>
   <recordsPeriodStartDate/>
   <precursor/>
   <recordSectionStatus>
     Opprettet
   </recordSectionStatus>
   <parent id="18"/>
   <documentMedium>
     Papyrus
   </documentMedium>
   <storageLocation/>
   <finalisedBy/>
   <periodStatus/>
   <record/>
   <title>
     Test Series 1
   </title>
   <createdBy>
     admin
   </createdBy>
   <finalisedDate/>
   <description/>
   <file/>
   <systemID>
     c23cfa35-0382-4010-9d96-6208cf5cd1a9
   </systemID>
   <recordsPeriodEndDate/>
   <classificationSystem/>
   <createdDate>
     2010-06-16 13:19:52.207 CEST
	</createdDate>
</series>


PUT /ws/series
~~~~~~~~~~~~~~~~

Updates and returns a series.

Example input:
<series id="32">
  <preservationAndDisposal/>
  <successor/>
   <recordsPeriodStartDate/>
   <precursor/>
   <recordSectionStatus>
     Opprettet
   </recordSectionStatus>
   <parent id="18"/>
   <documentMedium>
     Papyrus
   </documentMedium>
   <storageLocation/>
   <finalisedBy/>
   <periodStatus/>
   <record/>
   <title>
     Test Series 1 with updated values
   </title>
   <createdBy>
     admin
   </createdBy>
   <finalisedDate/>
   <description/>
   <file/>
   <systemID>
     c23cfa35-0382-4010-9d96-6208cf5cd1a9
   </systemID>
   <recordsPeriodEndDate/>
   <classificationSystem/>
   <createdDate>
     2010-06-16 13:19:52.207 CEST
	</createdDate>
</series>

Output should match input.

DELETE /ws/series/<id>
~~~~~~~~~~~~~~~~~~~~~~

Deletes a Series.

Example:

DELETE /ws/series/32 

should delete the Series with id 32.
