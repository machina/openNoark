<%! import org.friark.ds.* %>
<tr>
  <td><label for="title"><g:message code="title" default="Title"/></label></td>
  <td><g:textField id="title" name="title" value="${arkivdel?.title}"/></td>
</tr>
<tr>
  <td><label for="description"><g:message code="description" default="Description"/></label></td>
  <td><g:textField id="description"  name="description" value="${arkivdel?.description}"/></td>
</tr>
<tr>
  <td><label for="documentMedium"><g:message code="document.medium" default="Document medium"/></label></td>
  <td><g:textField id="documentMedium" name="documentMedium" value="${arkivdel?.documentMedium}"/></td>
</tr>

<tr>
  <td><label for="klasifikasjonystem"><g:message code="classification.system" default="Classification system"/></label></td>
  <td><g:select name="classificationSystem" value="${arkivdel?.classificationSystem}" noSelection="${['':message(code:'select',default:'Select ...')]}" from='${ClassificationSystem.list()}' optionKey="id" optionValue="title"></g:select>
</tr>
<tr>
  <td><label for="arkivperiodestartdato"><g:message code="series.period.start.date" default="Period start date"/></label></td>
  <td><g:datePicker name="recordsPeriodStartDate" value="${arkivdel?.recordsPeriodStartDate ? arkivdel?.recordsPeriodStartDate : 'none'}" noSelection="['':message(code:'select',default:'Select ...')]" precision="day"/></td>
</tr>
<tr>
  <td><label for="arkivperiodesluttdato"><g:message code="series.period.end.date" default="Period end date"/></label></td>
  <td><g:datePicker name="recordsPeriodEndDate" value="${arkivdel?.recordsPeriodEndDate ? arkivdel?.recordsPeriodEndDate : 'none'}" noSelection="['':message(code:'select',default:'Select ...')]" precision="day"/></td>
</tr>
<tr>
  <td><label for="parent"><g:message code="precursor" default="Precursor"/></label></td>
  <td><g:select name="precursor" value="${arkivdel?.precursor}" noSelection="${['':message(code:'select',default:'Select ...')]}" from='${Series.list()}' optionKey="id" optionValue="title"></g:select>
</tr>
<tr>
  <td><label for="parent"><g:message code="successor" default="Successor"/></label></td>
  <td><g:select name="successor" value="${arkivdel?.successor}" noSelection="${['':message(code:'select',default:'Select ...')]}" from='${Series.list()}' optionKey="id" optionValue="title"></g:select>
</tr>
<g:if test="${arkivdel == null}">
  <tr>
    <td><label for="referanseparent"><g:message code="fonds" default="Fonds"/></label></td>
    <td><g:select name="parent" value="${arkivdel?.parent?.id}"  noSelection="${[null:message(code:'select',default:'Select ...')]}" from='${Fonds.list()}' optionKey="id" optionValue="title"></g:select>
  <tr>
</g:if>