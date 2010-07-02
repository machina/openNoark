package org.friark

import no.friark.ds.*

class RecordService{
   static transactional = true

   def commonService

   def create( def params ){

      commonService.log( 'Creating new Record with params: ' + params )
   }

   def retrieve( def id ){
      commonService.log( 'Retrieving  Record id: ' + id )
   }

   def update( def params ){
      commonService.log( 'Updating  Record id: ' + id + ' with params ' + params )
   }

   def delete( def id ){
      def success = false
      def record = Record.get( id )

      if( record != null ){
	  record.delete()
	  success = true
      }

      commonService.log( 'Deleting Record id: ' + id + ', status: ' + success)
      return success;
   }
}
