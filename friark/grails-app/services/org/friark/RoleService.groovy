package org.friark

import no.friark.ds.*

class RoleService{ 
   static transactional = true

   def commonService

   def create( def params ){

      commonService.log( 'Creating new Role with params: ' + params )
   }

   def retrieve( def id ){
      commonService.log( 'Retrieving  Role with id: ' + id )
   }

   def update( def params ){
      commonService.log( 'Updating  Role id: ' + id + ' with params ' + params )
      def success = false;

      def role = ShiroRole.get(params.id)

      if( params.del_perm )
        

      return success;
   }

   def delete( def id ){
      def success = false
      def role = Role.get( id )

      if( role != null ){
          role.delete()
          success = true
      }

      commonService.log( 'Deleting Role with id: ' + id + ', status: ' + success)
      return success;
   }
}
