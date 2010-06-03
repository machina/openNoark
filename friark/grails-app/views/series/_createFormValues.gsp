<%! import no.friark.ds.* %>
            <tr>
              <td><label for="title">Tittel</label></td>
              <td><g:textField id="title" name="title" value="${arkivdel?.title}"/></td>
            </tr>
            <tr>
              <td><label for="description">Beskrivelse</label></td>
              <td><g:textField id="description"  name="description" value="${arkivdel?.description}"/></td>
            </tr>
            <tr>
              <td><label for="documentMedium">Dokument Medium</label></td>
              <td><g:textField id="documentMedium" name="documentMedium" value="${arkivdel?.documentMedium}"/></td>
            </tr>
            <%-- <tr>
              <td><label for="createdDate">Opprettet</label></td>
              <td><g:datePicker name="createdDate" value="${arkivdel?.createdDate ? arkivdel.createdDate : new Date()}" noSelection="['':'-Velg-']"/></td>
            </tr>
            <tr>
              <td><label for="createdBy">Opprettet av</label></td>
              <td><g:textField id="createdBy" name="createdBy" value="${arkivdel?.createdBy}"/></td>
            </tr> --%>
            <tr>
              <td><label for="klasifikasjonystem">Klasifikasjonystem</label></td>
              <td><g:select name="classificationSystem" value="${arkivdel?.classificationSystem}" noSelection="${['':'Velg Klasifikasjonsystem']}" from='${ClassificationSystem.list()}' optionKey="id" optionValue="title"></g:select>
            </tr>
            <tr>
              <td><label for="arkivperiodestartdato">Periode start</label></td>
              <td><g:datePicker name="recordsPeriodStartDate" value="${arkivdel?.recordsPeriodStartDate ? arkivdel?.recordsPeriodStartDate : 'none'}" noSelection="['':'-Velg-']" precision="day"/></td>
            </tr>
            <tr>
              <td><label for="arkivperiodesluttdato">Periode slutt</label></td>
              <td><g:datePicker name="recordsPeriodEndDate" value="${arkivdel?.recordsPeriodEndDate ? arkivdel?.recordsPeriodEndDate : 'none'}" noSelection="['':'-Velg-']" precision="day"/></td>
            </tr>
						<tr>
              <td><label for="parent">Forløper</label></td>
              <td><g:select name="precursor" value="${arkivdel?.precursor}" noSelection="${['':'Velg parent arkiv']}" from='${Series.list()}' optionKey="id" optionValue="title"></g:select>
            </tr>
            <tr>
              <td><label for="parent">Arvtaker</label></td>
              <td><g:select name="successor" value="${arkivdel?.successor}" noSelection="${['':'Velg parent arkiv']}" from='${Series.list()}' optionKey="id" optionValue="title"></g:select>
            </tr>
						<g:if test="${arkivdel == null}">
							<tr>
								<td><label for="referanseparent">Fonds</label></td>
								<td><g:select name="parent" value="${arkivdel?.parent?.id}"  noSelection="${[null:'Velg parent arkiv']}" from='${Fonds.list()}' optionKey="id" optionValue="title"></g:select>
							<tr>
						</g:if>
	
